config.resolve.modules.push("../../processedResources/frontend/main");
config.resolve.conditionNames = ['import', 'require', 'default'];


if (config.devServer) {
    config.devServer.hot = true;
    config.devServer.allowedHosts = ['auto','poodle.srv64.de'];
    config.devServer.host = '0.0.0.0';
    config.devServer.https = true;
    config.devtool = 'eval-cheap-source-map';
} else {
    config.devtool = undefined;
}

// disable bundle size warning
config.performance = {
    assetFilter: function (assetFilename) {
      return !assetFilename.endsWith('.js');
    },
};
