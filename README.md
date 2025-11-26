##🚀 Spring Boot CI/CD Pipeline Projec
이 프로젝트는 GitHub Actions → Docker Hub → AWS EC2까지 이어지는 완전한
CI/CD 자동화 파이프라인을 구성하는 예제입니다.

코드를 push하면:

빌드 → 테스트 → Docker 이미지 생성 → Docker Hub 업로드 → EC2 배포
까지 자동으로 이루어집니다.

##📌 전체 구조
```
로컬 개발
   ↓
GitHub Push
   ↓
GitHub Actions (CI)
 - Gradle 빌드
 - 단위 테스트 수행
 - Docker 이미지 생성
 - Docker Hub 업로드
   ↓
AWS EC2 (CD)
 - Docker Hub 이미지 pull
 - 컨테이너 실행
```

##📁 프로젝트 구조
```
src
 ├── main
 │    ├── java/com.test.team
 │    │      └── controller/MainController.java
 │    └── resources/templates/index.html
 └── test
      └── java/com.test.team.repository/TestRepositoryTests.java
```

##🐳 Dockerfile

프로젝트 루트/Dockerfile
```
FROM amazoncorretto:17-alpine
WORKDIR /app
COPY build/libs/*.jar app.jar
ENTRYPOINT [ "java", "-jar", "/app/app.jar" ]
```

##⚙️ GitHub Actions

프로젝트 루트에 아래 디렉터리를 생성:
```
.github/
 └── workflows/
        ├── hello.yml
        └── ci-cd.yml
```
#✔ ci-cd.yml 주요 기능

main 브랜치 push → 자동 실행

소스 체크아웃

JDK 설치

Gradle 빌드

단위 테스트 실행

Docker 이미지 생성

Docker Hub 업로드

테스트 실패 시 GitHub Issue 자동 생성

##🐞 테스트 실패 자동 이슈 생성

.github/TEST_FAILURE_TEMPLATE.md
```
---
title: 단위 테스트 실패 - {{ date | date('YYYY-MM-DD HH:mm') }}
assignees: 
  - ${{ env.GITHUB_ACTOR }}
labels: 
  - bug
  - test-failure
---

@${{ env.GITHUB_ACTOR }} 단위 테스트가 실패했습니다!

**커밋:** ${{ env.GITHUB_SHA }}
**브랜치:** ${{ env.GITHUB_REF }}

[워크플로우 실행 결과 확인하기](
${{ env.GITHUB_SERVER_URL }}/${{ env.GITHUB_REPOSITORY }}/actions/runs/${{ env.GITHUB_RUN_ID }}
)
```

GitHub Actions 설정:
```
- name: 테스트 실패 시 이슈 생성하기
  if: failure()
  uses: JasonEtco/create-an-issue@v2
  env:
    GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
  with:
    filename: .github/TEST_FAILURE_TEMPLATE.md
    assignees: ${{ github.actor }}
```

##🚚 AWS EC2 배포

EC2에서 최신 이미지 pull + 실행:
```
docker pull bunohoq/team
docker rm -f team
docker run -d --name team -p 8080:8080 bunohoq/team
```
##▶️ 로컬 실행 방법
./gradlew clean build
java -jar build/libs/app.jar


혹은 Docker로:
```
docker build -t team .
docker run -p 8080:8080 team
```

###🌐 기본 라우팅
URL	설명
/	index.html 렌더링
/index	동일
📘 API 문서 (템플릿)

향후 API가 추가되면 아래 형식으로 문서를 정리하세요.

###🔹 GET /api/example

설명: 예제 API
응답 예시:

{
  "message": "hello"
}

###📌 요약
기능	포함 여부
GitHub Actions CI	✅
Docker 빌드 자동화	✅
Docker Hub 업로드	✅
EC2 Pull & Run	✅
단위 테스트 자동 실행	✅
테스트 실패 자동 Issue 생성	✅
README 문서 정리	✅
