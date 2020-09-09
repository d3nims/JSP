서블릿 웹프로젝트 만들기
이클립스 실행


왼쪽 프로젝트 익스플로러에서 우클릭 후 project 클릭


프로젝트 익스플로러가 없으면 상단 도구메뉴 중 window - show view - project explorer 선택
select a wizard에서 web으로 검색. Dynamic Web Project 선택


project name 정한후 Target runtime이 비어있으면 옆에 New Runtime 버튼 클릭.


리스트가 뜨면 Apache Tomcat 8.5 선택 후 next
browse 버튼 누른 후 tomcat이 실제 설치된 폴더 선택
이후 finish 버튼으로 완료
Dynamic web module version은 3.1로 선택하고 나머진 건들지 않고 next 진행.


폴더구조는 그대로 next 진행

Web Module도 그대로 finish 완료


좌측 project explorer에 프로젝트 생성됨. 하위폴더에 Java Resources 밑에 src 폴더 클릭후 우클릭 - new - Servlet 선택.


Class name만 정해주고 next - URL mapping 그대로 next 진행 - doGet만 선택 - finish 완료
