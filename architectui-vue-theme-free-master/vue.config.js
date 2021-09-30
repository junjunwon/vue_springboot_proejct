const path = require("path");

module.exports = {
    runtimeCompiler: true,
    productionSourceMap: false,
    outputDir: path.resolve(__dirname, "./path"),
    devServer : {
        port : 3031,
        proxy : {
            '/' : {
                target : 'http://localhost:3000'
            }
        }
    },
    publicPath: process.env.NODE_ENV === 'production'
        ? './'
        : '/'
}