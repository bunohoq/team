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

[워크플로우 실행 결과 확인하기](${{ env.GITHUB_SERVER_URL }}/${{ env.GITHUB_REPOSITORY }}/actions/runs/${{ env.GITHUB_RUN_ID }})