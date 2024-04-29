# Spring Boot - Boilerplate

## 포함된 기능

- Spring Boot 3.2.2
- Spring Data JPA
- Test
  - JUnit5
  - Mockito
- Log
  - Slf4j
  - Logback
- Documentation
  - Swagger
- Cache
  - Redis
- Docker
  - Dockerfile
- AOP

## 현재 제 고민
1. 현재 방식이 좋은지? 디벨롭 할 수 있는지?
2. 현재 방식을 고수한다고하면 지금 코드는 좋은지? (확장성)
3. 기능적으로 디벨롭
- 지금 딱 코드 실행만 되는 상태 -> 채점을 제대로 할 수 있도록
  (에러 메세지를 보낸다거나, print 찍은 거랑 return값이랑 구분해서 결과를 준다던지, 결과값 타입 체크가 제대로 됐는지, 언어별 시스템 보안에 문제가 있을 수 있는 코드 검사..)
- 카프카 연결