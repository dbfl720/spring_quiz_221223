<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   
            
                <article class=" h-50">
                    <!-- 같은 폴더에 있으면 이름만 쓰면 img 첨부됨. -->
                   <img id="mainImg" src="/img/booking/house1.jpeg" alt="배너 이미지" width="1110px" height="450">		
                   <div class="d-flex justify-content-between">
                   <button id="prev" type="button" class="btn btn-light">이전</button>
                   <button id="next" type="button" class="btn btn-light">다음</button>	
                   </div>			
                </article>
                
                
                <article class="article2 ">
                    <h3 class="section-text mt-5 mb-3">Best houses</h3>
                  
                    <!-- article == div 같다!  -->
                    <!-- justify-content-around : 양옆에 약간 여백이 생기면서 가운데 정렬. -->
                    <div class="d-flex justify-content-between align-items-center">
                    
                            <div><a href="#"><img src="/img/booking/house2.jpeg" alt="이미지1" width="220px" height="230px" class="pics" ></a>
                               <div class="mt-3"><div class="img-text font-weight-bold">스위스 통나무 가정집</div>
                                <!-- <del>을 사용하면 글자에 취소선이 생김. -->
                                    <!-- text-secondary: 회색글자 만들어짐. -->
                                <del class="article-text1 text-secondary">1박 150,000원</del>
                                <div class="font-weight-bold">&#x1F4B0;Unavailable Now</div></div> 
                            </div>
                                  
                            <div><a href="#"><img src="/img/booking/house3.jpeg" alt="이미지1" width="220px" height="230px" class="pics" ></a>
                                <div class="mt-3"><div class="img-text font-weight-bold">새소리에 취하기</div>
                                <del class="article-text1 text-secondary">1박 300,000원</del>
                                <div class="font-weight-bold">&#x26F5;1박 1,500,000원</div></div>
                            </div>
                            <div><a href="#"><img src="/img/booking/house4.jpeg" alt="이미지1" width="220px" height="230px" class="pics" ></a>
                                <div class="mt-3"><div class="img-text font-weight-bold">냇가 앞에 외톨이</div>
                                <del class="article-text1 text-secondary">2박 250,000원</del>
                                <div class="font-weight-bold">⛱ 4박 450,000원</div></div>
                            </div>
                            <div><a href="#"><img src="/img/booking/house5.jpeg" alt="이미지1" width="220px" height="230px"  class="pics" ></a>
                                <div class="mt-3"><div class="img-text font-weight-bold">야생동물과 공존</div>
                                <del class="article-text1 text-secondary">8박 100,000원</del>
                                <div class="font-weight-bold">&#x1F381;10박 100,000원</div></div>
                            </div>
                            <div><a href="#"><img src="/img/booking/house6.jpeg" alt="이미지1" width="220px" height="230px" class="pics" ></a>
                                <div class="mt-3"><div class="img-text font-weight-bold">혼자있고 싶은 날</div>
                                <del class="article-text1 text-secondary">1박 120,000원</del>
                                <div class="font-weight-bold">&#x1F4B0;1박 80,000원</div></div>
                            </div>
                      
  
                    </div>
                </article>
                
                
  <script>
  	$(document).ready(function() {
  		var imgs = ['/img/booking/house1.jpeg', '/img/booking/house2.jpeg', '/img/booking/house3.jpeg', '/img/booking/house4.jpeg' , '/img/booking/house5.jpeg', '/img/booking/house6.jpeg'];
  		var currentIndex = 0;
  		
  		// 다음 버튼 클릭
  		$("#next").on("click", function() {
  			currentIndex++;
  			if (currentIndex >= imgs.length) {
  				currentIndex = 0;
  			}
  			
  			$('#mainImg').attr("src", imgs[currentIndex]);
  			
  		});
  		
  		
  		// 이전 버튼 클릭
  		$("#prev").on("click", function() {
  			currentIndex--;
  			if (currentIndex < 0) {
  				currentIndex = imgs.length -1;
  			}
  			
  			$('#mainImg').attr("src", imgs[currentIndex]);
  			
  			
  		});
  		
  	});  // ready
  	
  
  </script>
