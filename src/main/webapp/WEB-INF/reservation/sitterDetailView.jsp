<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
    <title>돌보미 상세정보</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Righteous&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/header.css"/>
    <link rel="stylesheet" href="../css/footer.css"/>
    <link rel="stylesheet" href="../css/sitterDetailView.css"/>
    <script src="../js/sitterDetailView.js"></script>
</head>

<body>
<div id="headerWrap">
        <div id="headerInner">
            <div id="logo">PIT A PET</div>
            <div id="gnb">
                <div id="sitterListLink">돌보미 조회</div>
                <div id="reviewLink">이용 후기</div>
                <div id="likeLink">좋아요</div>
                <div id="myPageLink">마이페이지</div>
                <button id="headerLoginBtn">로그인</button>
            </div>
        </div>
    </div>

    <div id="detailViewWrap">
        <div id="pageTit">돌보미 상세정보</div>
        <div id="detailWrap">
            <div id="detailBox">
                <div id="detailPetSitterName">### 반려동물 돌보미</div>
                <img src="../images/detailNulImg.svg" />
                <div id="targetLocation">상월곡</div>
                <div id="likeCountWrap">
                    <img src="../images/smallHeart.svg" id="smallHeart" />
                    <div id="likeCount">12</div>
                </div>
                <div id="detailInner">
                    <div id="detailTit">(제목)</div>
                    <div id="detailIntro">(소개)</div>
                    <div id="serviceCaringWrap">
                        <div id="petSitterServiceWrap">
                            <div id="serviceTit">제공 서비스</div> 
                            <div id="petSitterService">(제공서비스)</div>
                        </div>
                        <div id="caringDateWrap">
                            <div id="caringPetsWrap">
                                <div id="caringTit">돌봄 가능 반려동물</div>
                                <div id="caringPet">대형견</div>
                                <div id="caringPet">소형견</div>
                                <div id="caringPet">고양이</div>
                            </div>
                        </div>
                        <div id="lookUpDate">2021-11-01</div>
                    </div>
                </div>
            </div>
            <div>
                <div id="ableTimeWrap">
                    <table class="scriptCalendar">
                        <thead>
                            <tr>
                                <div id="ableTimeTit">예약 가능일</div>
                            </tr>
                            <tr>
                                <td onClick="prevCalendar();" style="cursor:pointer;"><img src="../images/calLeft.svg" /></td>
                                <td colspan="5" id="calYearMonth">
                                    <span id="calYear">YYYY</span>년
                                    <span id="calMonth">MM</span>월
                                </td>
                                <td onClick="nextCalendar();" style="cursor:pointer;"><img src="../images/calRight.svg" /></td>
                            </tr>
                            <tr>
                                <td>일</td><td>월</td><td>화</td><td>수</td><td>목</td><td>금</td><td>토</td>
                            </tr>
                        </thead>
                        <tbody></tbody>
                    </table>
                </div>
                <button id="reservationBtn">예약하기</button>
            </div>
        </div>

        <div id="detailReviewTit">리뷰작성</div>
        <div id="detailReviewWrap">
            <textarea placeholder="리뷰를 작성해주세요." id="reviewText"></textarea>
            <div id="fileReviewBtnWrap">
                <div id="fileWrap">
                    <img src="../images/fileImg.svg" id="fileImg"/>
                    <input type="file" id="fileBtn"/>
                </div>
                <button id="detailReviewBtn">리뷰 등록</button>
            </div>
        </div>

        <div id="reviewTitWrap">
            <div id="reviewTit">이용 후기</div>
            <div id="scopeWrap">
                <img src="../images/star.svg"/>
                <div id="scope">5.0</div>
            </div>
        </div>

        <div id="petSitterInfoBox">
            <img src="../images/petSitterNullImg.svg" id="petSitterImg" />
            <div id="petSitterLocation">상월곡</div>
            <div id="petSitterInfoInner">
                <div id="petSitterNameLikeWrap">
                    <div id="petSitterName">### 반려동물 보호자님</div>
                    <div id="lookUpDate">2021-11-01</div>
                </div>
                <div id="petSitterIntro">(후기)</div>
                <div id="serviceCaringWrap">
                    <div id="caringDateWrap">
                        <div id="caringPetsWrap">
                            <div id="caringTit">about ### 반려동물 돌보미</div>
                        </div>
                        <div id="scopeWrap">
                            <img src="../images/star.svg"/>
                            <div id="scope">5.0</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="petSitterInfoBox">
            <img src="../images/petSitterNullImg.svg" id="petSitterImg" />
            <div id="petSitterLocation">상월곡</div>
            <div id="petSitterInfoInner">
                <div id="petSitterNameLikeWrap">
                    <div id="petSitterName">### 반려동물 보호자님</div>
                    <div id="lookUpDate">2021-11-01</div>
                </div>
                <div id="petSitterIntro">(후기)</div>
                <div id="serviceCaringWrap">
                    <div id="caringDateWrap">
                        <div id="caringPetsWrap">
                            <div id="caringTit">about ### 반려동물 돌보미</div>
                        </div>
                        <div id="scopeWrap">
                            <img src="../images/star.svg"/>
                            <div id="scope">5.0</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="footerWrap">
        <div id="footerText">Copyrights © 2021 by 윤김구이. All Rights Reserved.</div>
    </div>
</body>
</html>