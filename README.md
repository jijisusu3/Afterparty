# 🎬Afterparty   
<br>
<div align="center">
    <img width="70%" src="https://user-images.githubusercontent.com/97671781/184832143-b5e2617f-ca09-4b6c-bad6-d2801c5671d1.png"/>
</div>
<br>   

## 📰 Project Outline   

We noticed 'Salon culture', popular in Korea in the twenties and thirties people before the Pandemic. 
Salon is rooted in regular social gatherings for the French upper class and literati. In modern times, it has become a gathering where individuals with similar hobbies to communicate their opinions freely.  
<br>
As the number of single-person households rapidly increases, single-person households are emerging as a new consumer market player.
Especially, we noted the rise of solo attendees at performances, and they have become the primary market consumers in the performing arts.
We decided to build this service targeting solo attendees. 
<br>
'Afterparty' is started for the person even if they enjoy the performance alone, wants to communicate with the same preference.
Everyone who loves a musical and performing can come to our website and communicate what they saw and enjoyed.
Our goal is to give a prompt and freestyle 'Salon' for users without a limit of space like an 'Afterparty'. 

<br>
📽️ UCC 

* * *
<br>

## 🌟 Team
|Name|Jisu Kim|유강현|이성훈|전지수|조다연|차송희|
|---|:----:|:----:|:----:|:----:|:----:|:----:|
|**Profile**|<img height="100px" width="100px" src="https://avatars.githubusercontent.com/u/97648027?v=4"/>|<img height="100px" width="100px" src="https://avatars.githubusercontent.com/u/97591826?v=4"/>|<img height="100px" width="100px" src="https://avatars.githubusercontent.com/u/71359353?v=4"/>|<img height="100px" width="100px" src="https://avatars.githubusercontent.com/u/97648037?v=4"/>|<img height="100px" width="100px" src="https://avatars.githubusercontent.com/u/97671781?v=4"/>|<img height="100px" width="100px" src="https://avatars.githubusercontent.com/u/44563011?v=4"/>|
|**Position**|Frontend<br>Reader|Frontend<br>Team Reader<br>Infra|Backend<br>UCC|Frontend<br>Git Assignee|Backend<br>Reader<br>Doc Manager|Backend<br>Git Manager<br>Infra|
|**Git**|<a href="https://github.com/jijisusu3">@jijisusu3</a>|<a href="https://github.com/kanyu97">@kanyu97</a>|<a href="https://github.com/Lee-sung-hoon">@Lee-sung-hoon</a>|<a href="https://github.com/zyyyyyysoo">@zyyyyyysoo</a>|<a href="https://github.com/dus6982">@dus6982</a>|<a href="https://github.com/chasonghui">@chasonghui</a>|   
* * *
<br>

## 🛠️ Tech Stack    

![기술스택_최종](https://user-images.githubusercontent.com/97671781/185521253-13d89547-4d94-411c-ab0f-fae83535f3fc.jpg)   
<br>   

|Tech|Stack|   
|:---|:---------------------|   
|**Backend**|Java, Spring Boot, JPA, JWT, MySQL|      
|**Frontend**|JavaScript, Vue.js, Pinia, Vuex|   
|**Tools**|AWS EC2, NginX, Docker, GitLab, JIRA, Notion, Openvidu, WebRTC, KOPIS API, KaKao Map API|   

* * *
<br>

## 📌 System Architecture   
<br>

![시스템아키텍처](https://user-images.githubusercontent.com/97671781/185304511-1e0291ab-71dc-48c3-99a7-56509e11d105.jpg)

* * *
<br>

## 🔎 Main Functionality   
#### 1. Conference room   

- View video conference room list and search conditions
![뒤풀이방](https://user-images.githubusercontent.com/97671781/185528375-00add14a-cc94-480d-b350-9b2c4fd3f99c.PNG)   

- Creat a video conference room by entering the conditions (when only spectators are selected, the performance information input box is activated; when everyone is selected the performance information input box is deactivated)
![방만들기](https://user-images.githubusercontent.com/97671781/185530571-a81f3865-3c02-4e60-91a2-e5bfbcd53dc5.PNG)   

- Entering the video conference room and chat
![화상회의입장](https://user-images.githubusercontent.com/97671781/185530697-269f13d6-d52d-4a7b-bdf1-1526351ad90c.png)


#### 2. Search the performance info - using KOPIS API   

- Search for desired performances (by genre, filtering conditions)
![공연찾기](https://user-images.githubusercontent.com/97671781/185531072-703ffcab-36d0-4541-a2ae-47d9f9816d39.PNG)   

- View detailed performance information (show location using KAKAO API)
![공연상세정보](https://user-images.githubusercontent.com/97671781/185532046-48b8da57-1e15-4c17-86e8-1f784ec096f4.png)
![공연지도](https://user-images.githubusercontent.com/97671781/185531927-4af15a5e-3e5c-48c1-9c2c-886f5b61b1a3.png)   


#### 3. Online community    

- Communicate by genre
![뮤지컬탭](https://user-images.githubusercontent.com/97671781/185531093-ac493874-4a6b-449d-8d41-5c471173a6dd.PNG)


#### 4. Main page   

- The above three functions can be accessed through the corresponding page !    
![메인](https://user-images.githubusercontent.com/97671781/185530941-f1b2a162-e19a-4bcc-962a-8cb1175209a6.png)   


* * *
<br>   

## 🔗 WIKI
📖 [Team Notion](https://www.notion.so/1077c3bc1d954b9788adb19d57a2bed1)   
🙌 [Git Convention](https://www.notion.so/Git-Convention-cf8040187a7a4abeadc1b63ba9ac99dc) | [Jira Convention](https://www.notion.so/Jira-a44878185b8b4ebe9989eacbcdb6bd58)   
📜 [API 명세서](https://www.notion.so/d0348f73a27f4ba3aaa8dddba6b173f7?v=2fa7c9b510014468b3a0acc7893d7bfa) | [ERD](https://www.erdcloud.com/d/NALFTQamYNgu2epWZ) | [FIGMA](https://www.figma.com/file/AHYHvryDoVUn6Mhqx3yD4P/SSAFY-7%EA%B8%B0-3%EC%A1%B0-%EA%B3%B5%ED%86%B5-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8?node-id=6%3A2)      

* * *   
<br> 

## ⚙️ Deployment
🔧 [EC2 원격설정](https://chasonghui.notion.site/EC2-6bc439b748dd44598b9b88a2c4c1b54b)   
💡 [Menual of deployment guide](https://chasonghui.notion.site/0fff0ab7b348491c883c825a4ce9f1e4)   
🔧 [openvidu preferences](https://chasonghui.notion.site/Openvidu-8814806bfa5e4c20977414d8cb13a2eb)   
💡 [Understanding deployment structure](https://chasonghui.notion.site/2445145deb214b6a8526d2be3e725cc8)   

* * *    
<br> 

