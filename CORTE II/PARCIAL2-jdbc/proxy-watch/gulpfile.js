const gulp = require('gulp');
const browserSync = require('browser-sync').create();
const watch = require('node-watch');
const cmd = require('cmd-exec').init();
const path = require('path');

//recordar- ant debe estár en las variables de entorno, lo mismo que los JDK y JRE
// Ubicar el path de tomcat

//cambio orlando testeo

let splited = __dirname.split(path.sep);

let pathlocal = '';
__dirname.split(path.sep).forEach(d => {
  if (d != splited.pop() && splited[splited.length-1] ) pathlocal += `${d}//`;
});

console.log(pathlocal);
let test = pathlocal.split('//');

const basic = {
  project_name_folder: test[test.length-2],
  project_path: `${pathlocal}`,
};

const config = {
  project_name_folder: basic.project_name_folder,
  project_path: basic.project_path,
  project_path_build_web: `${basic.project_path}\\build\\web`,
  tomcat_path: 'C:\\xampp\\tomcat',
  tomcat_proxy: `http://localhost:8080/${basic.project_name_folder}`,
  port_watch: 3500,
  watch_: false,
};

gulp.task('default', () => {
  sync_files();

  watch(
    config.project_path,
    {
      recursive: true,
      delay: 1000,
      filter: f => !/(.git|.idea|node_modules|external_libs|build)/.test(f),
    },
    (evt, name) => {
      console.log('%s changed.', name);
      sync_files();
    },
  );
  browserSync.init({
    proxy: config.tomcat_proxy,
    port: config.port_watch,
    watch: config.watch_,
    files: [`${config.tomcat_path}\\webapps\\${config.project_name_folder}`],
    //files: ['D:\\Software\\ProyectosWEB\\JAVA\\jsp-servlets-react'],
  });
});

async function sync_files() {
  await cmd.exec(`cd "${config.project_path}" && ant compile`, (err, res) => {
    if (err) {
      //console.log(err.message);
    } else {
      console.log('[Builded]');
    }    
  });
  
  await cmd.exec(
    `xcopy "${config.project_path_build_web}" "${config.tomcat_path}\\webapps\\${
      config.project_name_folder
    }"  /e /s /k /q /c /i /y /h`,
    (err, res) => {
      if (err) {
        console.log(err.message);
      } else {
        console.log(res.message);
      }
    },
  );
}
