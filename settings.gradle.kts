plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "spring-cloud-gateway-drill"
include("gateway-webmvc")
include("example-service")
include("example-service:a-service")
include("example-service:b-service")
include("example-service:c-service")
include("gateway-webflux")
include("gateway-config")