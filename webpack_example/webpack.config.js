
const HtmlWebpackPlugin = require('html-webpack-plugin');
const path = require('path'); // built-in node module

module.exports = {
    entry: './src/index.js',
    output: {
        filename: 'bundle[hash].js',
        path: __dirname + '/dist',
    },
    plugins: [new HtmlWebpackPlugin({
        template: path.resolve(__dirname, "src", "index.html")
    })],
    devServer: {
        port: 9000
    },
    module: {
        rules: [
            {
                test: /\.css$/,
                use: ['style-loader', 'css-loader']
            },
            {
                test: /\.js(x)$/,
                use: 'babel-loader',
                exclude: /node_modules/
            }
        ]
    }
}