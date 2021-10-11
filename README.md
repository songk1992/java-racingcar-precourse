# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)



# 구현할 기능 목록 / TODO List
(테스트 먼저 만들고 코드 작성)

* TODOLiSt 작성

* MVC 패턴의 틀 작성

* 자동차 정보 입력
  •각자동차에이름을부여할수있다.전진하는자동차를출력할때자동차이름을같이출력한다.
  •자동차이름은쉼표(,)를기준으로구분하며이름은5자이하만가능하다.
  •사용자는몇번의이동을할것인지를입력할수있어야한다.
  •사용자가잘못된값을입력할경우“[ERROR]”로시작하는에러메시지를출력후입력을다시받는다.

* 자동차 전진 기능 구현
  •전진하는조건은0에서9사이에서random값을구한후random값이4이상일경우전진하고,3이하의값이면멈춘다.
  •주어진 횟수동안 n대의자동차는전진또는멈출수있다.

* 우승자 판별
  * 우승자 출력
  •자동차경주게임을완료한후누가우승했는지를알려준다.
  •우승자가한명이상일경우,쉼표(,)로이름을구분해출력한다.

* 코드 추가 리팩터


# Personal Notes

---

## 개요

* 프리코스 자동차 경주 게임 미션

## Git Command Note

```
git clone https://github.com/{본인_아이디}/{저장소 아이디}.git
git checkout -b 브랜치이름
git status // 변경된 파일 확인
git add -A(또는 .) // 변경된 전체 파일을 한번에 반영
git commit -m "메시지" // 작업한 내용을 메시지에 기록
git push origin 브랜치이름
```

## "Campus Hack Day" Java Coding Convention

* https://naver.github.io/hackday-conventions-java/

## "AngularJS" Commit log Convention

* https://gist.github.com/stephenparish/9941e89d80e2bc58a153

## Intelli J code format 단축키
* Ctrl+Alt+L(윈도우)
