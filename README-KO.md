E# 🎬뒤풀이어   
<br>
<div align="center">
    <img width="70%" src="https://user-images.githubusercontent.com/97671781/184832143-b5e2617f-ca09-4b6c-bad6-d2801c5671d1.png"/>
</div>
<br>   

## 📰 프로젝트 개요   
코로나 이전 MZ세대라 불리는 2030 세대에서 유행했던 **'살롱문화'** 에 주목했습니다.   
살롱 문화란 18세기 프랑스 상류 사회에서 귀족과 문인들이 가지던 정기적 사교모임 문화에 뿌리를 두고 있습니다.    
현대에 와서는 비슷한 취미를 가진 개인들이 모여 자유로운 관계 속에서 자신의 취향 이야기를 순수하게 소통하는 모임이 되었습니다.   
<br>
1인 가구가 빠르게 증가하면서 ‘솔로 이코노미’ 라는 용어가 등장할 만큼 1인 가구는 새로운 소비 시장의 주체로 부상하고 있습니다.  
특히 인터파크에서 조사한 공연 예매비율에서 혼자서 공연을 즐기는 **'혼공족'** 이 점차 증가해왔다는 점에 주목했고,   
공연 1인 관객을 대상으로 하는 서비스를 구상하게 되었습니다.   
<br>
개인 취미를 혼자 즐기면서도 같은 취향을 가진 사람들과 소통하고 싶어하는 사람들,   
특히 혼자 공연을 즐기는 혼공족들을 위한  공간을 만들고자 기획하게 된 것이 `'뒤풀이어'` 입니다.    
<br>
>뮤지컬 및 공연 문화를 사랑하는 사람이라면 누구든 찾아와 비슷한 취향을 가진 사람과 함께 시시콜콜한 이야기를 떠들 수 있습니다.   
> 온라인인만큼 공간의 제약이 있는 오프라인 모임보다 더 자유롭고 즉흥적인 형식의 모임 서비스를 제공하는 것이 목표입니다.   
<br>
📽️ UCC 

* * *
<br>

## 🌟 Team
|Name|김지수|유강현|이성훈|전지수|조다연|차송희|
|---|:----:|:----:|:----:|:----:|:----:|:----:|
|**Profile**|<img height="100px" width="100px" src="https://avatars.githubusercontent.com/u/97648027?v=4"/>|<img height="100px" width="100px" src="https://avatars.githubusercontent.com/u/97591826?v=4"/>|<img height="100px" width="100px" src="https://avatars.githubusercontent.com/u/71359353?v=4"/>|<img height="100px" width="100px" src="https://avatars.githubusercontent.com/u/97648037?v=4"/>|<img height="100px" width="100px" src="https://avatars.githubusercontent.com/u/97671781?v=4"/>|<img height="100px" width="100px" src="https://avatars.githubusercontent.com/u/44563011?v=4"/>|
|**Position**|Frontend<br>Reader|Frontend<br>Team Reader<br>Infra|Backend<br>UCC|Frontend<br>Git Assignee|Backend<br>Reader<br>Doc Manager|Backend<br>Git Manager<br>Infra|
|**Git**|<a href="https://github.com/jijisusu3">@jijisusu3</a>|<a href="https://github.com/kanyu97">@kanyu97</a>|<a href="https://github.com/Lee-sung-hoon">@Lee-sung-hoon</a>|<a href="https://github.com/zyyyyyysoo">@zyyyyyysoo</a>|<a href="https://github.com/dus6982">@dus6982</a>|<a href="https://github.com/chasonghui">@chasonghui</a>|   
* * *
<br>

## 🛠️ 기술스택    

![기술스택_최종](https://user-images.githubusercontent.com/97671781/185521253-13d89547-4d94-411c-ab0f-fae83535f3fc.jpg)   
<br>   

|Tech|Stack|   
|:---|:---------------------|   
|**Backend**|Java, Spring Boot, JPA, JWT, MySQL|      
|**Frontend**|JavaScript, Vue.js, Pinia, Vuex|   
|**Tools**|AWS EC2, NginX, Docker, GitLab, JIRA, Notion, Openvidu, WebRTC, KOPIS API, KaKao Map API|   

* * *
<br>

## 📌 시스템 아키텍처   
<br>

![시스템아키텍처](https://user-images.githubusercontent.com/97671781/185304511-1e0291ab-71dc-48c3-99a7-56509e11d105.jpg)

* * *
<br>

## 🔎 주요 기능   
#### 1. 뒤풀이방   

- 화상회의 방 목록 조회 & 조건 검색
![뒤풀이방](https://user-images.githubusercontent.com/97671781/185528375-00add14a-cc94-480d-b350-9b2c4fd3f99c.PNG)   

- 화상회의 방 조건 입력하여 생성 (관람자만 선택 시 공연정보 입력칸 활성화, 모두참여 선택 시 공연정보 입력칸 비활성화)
![방만들기](https://user-images.githubusercontent.com/97671781/185530571-a81f3865-3c02-4e60-91a2-e5bfbcd53dc5.PNG)   

- 화상회의 방 입장 (채팅)
![화상회의입장](https://user-images.githubusercontent.com/97671781/185530697-269f13d6-d52d-4a7b-bdf1-1526351ad90c.png)


#### 2. 공연찾기 - KOPIS API   

- 원하는 공연 검색 (장르별, 조건 필터링별)
![공연찾기](https://user-images.githubusercontent.com/97671781/185531072-703ffcab-36d0-4541-a2ae-47d9f9816d39.PNG)   

- 공연 상세 정보 조회 (KAKAO API로 장소까지)   
![공연상세정보](https://user-images.githubusercontent.com/97671781/185532046-48b8da57-1e15-4c17-86e8-1f784ec096f4.png)
![공연지도](https://user-images.githubusercontent.com/97671781/185531927-4af15a5e-3e5c-48c1-9c2c-886f5b61b1a3.png)   


#### 3. 커뮤니티    

- 장르별로 리뷰/자유게시판으로 나누어 소통
![뮤지컬탭](https://user-images.githubusercontent.com/97671781/185531093-ac493874-4a6b-449d-8d41-5c471173a6dd.PNG)


#### 4. 메인 화면   

- 위 3가지 기능을 한 번에 !    
![메인](https://user-images.githubusercontent.com/97671781/185530941-f1b2a162-e19a-4bcc-962a-8cb1175209a6.png)   


* * *
<br>   

## 🔗 WIKI
📖 [Team Notion](https://www.notion.so/1077c3bc1d954b9788adb19d57a2bed1)   
🙌 [Git Convention](https://www.notion.so/Git-Convention-cf8040187a7a4abeadc1b63ba9ac99dc) | [Jira Convention](https://www.notion.so/Jira-a44878185b8b4ebe9989eacbcdb6bd58)   
📜 [API 명세서](https://www.notion.so/d0348f73a27f4ba3aaa8dddba6b173f7?v=2fa7c9b510014468b3a0acc7893d7bfa) | [ERD](https://www.erdcloud.com/d/NALFTQamYNgu2epWZ) | [FIGMA](https://www.figma.com/file/AHYHvryDoVUn6Mhqx3yD4P/SSAFY-7%EA%B8%B0-3%EC%A1%B0-%EA%B3%B5%ED%86%B5-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8?node-id=6%3A2)      

* * *   
<br> 

## ⚙️ 배포 관련
🔧 [EC2 원격설정](https://chasonghui.notion.site/EC2-6bc439b748dd44598b9b88a2c4c1b54b)   
💡 [수동배포 가이드](https://chasonghui.notion.site/0fff0ab7b348491c883c825a4ce9f1e4)   
🔧 [openvidu 환경설정](https://chasonghui.notion.site/Openvidu-8814806bfa5e4c20977414d8cb13a2eb)   
💡 [배포 구조 이해하기](https://chasonghui.notion.site/2445145deb214b6a8526d2be3e725cc8)   

* * *    
<br> 

