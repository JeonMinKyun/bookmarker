FROM eclipse-temurin:17.0.11_9-jre-focal

#target 디렉토리에서 모든 jar 파일을 app.jar로 추가 
ADD target/*.jar app.jar

#컨테이너 내부의 포트 8080을 외부에 노출
EXPOSE 8080

#애플케이션 실행할 명령어 설정
ENTRYPOINT ["sh","-c", "java -jar /app.jar"]