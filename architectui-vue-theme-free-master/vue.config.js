const path = require("path");

module.exports = {
    runtimeCompiler: true,
    productionSourceMap: false,
    // outputDir: path.resolve(__dirname, "./path"),
    outputDir: path.resolve(__dirname, "../"+"src/main/resources/static"),
    devServer : {
        port : 3031,
        proxy : {
            '/' : {
                target : 'http://localhost:3000',
                ws : true,
                changeOrigin : true
            }
        }
    },
    publicPath: process.env.NODE_ENV === 'production'
        ? './'
        : '/'
}