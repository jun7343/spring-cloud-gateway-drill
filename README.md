# Spring Cloud Gateway Drill

## Goals

- Spring Cloud Gateway 사용하는 예제 구현.
- Spring Cloud Gateway + Authorization 예제 구현.
  - Spring Security를 통해 인증/인가 처리.
- Spring Cloud Gateway + PassPort 예제 구현.
  - 인증 처리된 사용자의 정보를 PassPort 객체를 upstream에 전달. (ex: Netflix PassPort)
- Spring Cloud Gateway + Rate Limiting 예제 구현.
  - IP 기반 Rate Limiting 1차 적용.
  - IP + User ID 기반 Rate Limiting 2차 적용.
- Spring Cloud Gateway + Circuit Breaker 예제 구현.
- Spring Cloud Gateway + Logging + Monitoring 예제 구현.
- Spring Cloud Gateway + Config 예제 구현
  - Gateway의 Routing을 동적으로 관리할 수 있는 Config 서버 구현.
  - Gateway의 Security Authorization 설정을 동적으로 관리할 수 있는 Config 서버 구현.

## Project Structure

- [gateway-config](./gateway-config): Spring Cloud Gateway 설정 파일.
  - 동적으로 API 라우팅 설정과 Security Authorization 설정을 등록 및 관리
  - server.port: 8081
- [example-service](./example-service): 예제 서비스.
  - 실제 API를 제공하는 서비스로, Gateway를 통해 접근.
  - 모든 API 요청은 최대 1초 이내 응답. (Thread sleep을 통해 지연 응답 처리)
  - [a-service](./example-service/a-service): A 서비스
    - server.port: 8082
  - [b-service](./example-service/b-service): B 서비스
    - server.port: 8083
  - [c-service](./example-service/c-service): C 서비스
    - server.port: 8084
- [gateway-webmvc](./gateway-webmvc): Spring Cloud Gateway 웹 MVC 예제.
  - server.port: 8080
- [gateway-webflux](./gateway-webflux): Spring Cloud Gateway 웹 플럭스 예제.
  - server.port: 8080


## How to Run

### Requirements
- Java 21
- Docker

### Gateway WebMVC

```shell
./gradlw gatewayWebmvcBuildImage && docker-compose up -f docker-compose-gateway-webmvc.yml
```

### Gateway WebFlux

```shell
./gradlew && docker-compose up -f docker-compose-gateway-webflux.yml
```
