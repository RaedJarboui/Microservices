const Eureka = require("eureka-js-client").Eureka;
const { config } = require("../config");

exports.registerWithEureka = function (appName, PORT) {
  const client = new Eureka({
    // application instance information
    instance: {
      app: `${appName}`,
      hostName: config.hostname.HOSTNAME,
      ipAddr: config.ipAddr.IPADD,
      port: {
        $: PORT,
        "@enabled": "true",
      },
      isCoordinatingDiscoveryServer: true,
      vipAddress: `${appName}`,
      dataCenterInfo: {
        "@class": "com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo",
        name: "MyOwn",
      },
      statusPageUrl: "http://localhost:" + PORT + "/api/client",
      registerWithEureka: true,
      fetchRegistry: true,
    },
    eureka: {
      // eureka server host / port
      host: config.eurekaHost.EUREKAHOST,
      port: config.eurekaPort.EUREKAPORT,
      servicePath: "/eureka/apps/",
      preferSameZone: true,
    },
  });
  client.logger.level("debug");

  client.start((error) => {
    console.log(error || "user service registered");
  });
};
