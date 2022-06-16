
package com.min.vo;

import java.io.Serializable;

public class RowNumVo implements Serializable{

   
   /**
	 * 
	 */
	private static final long serialVersionUID = -8707670077614675868L;
/*
    * pageList 출력된 페이지의 번호 갯수 (그룹에 몇개 포함되는지)
    * index 출력된 페이지의 번호 (몇번째 페이지인지)
    * pageStartNum 출력할 페이지의 시작번호
    * pageListNum 출력할 리스트의 갯수(1페이지에 출력될 게시글 갯수)
    * total 리스트의 총갯수
    */
   private int pageList; 
   private int index; 
   private int pageStartNum; 
   private int pageListNum; 
   private int total; 
   
   //기본 설정값으로 잡아준다.
   {
      pageList = 10;
      index=0;
      pageStartNum=1;
      pageListNum=15;
   }
   
   /*
    * 화면에서 변경되는 값의 처리 null은 첫페지의 호출시 값이 없음을 판단하기 쉬움 
    */
   public RowNumVo(String index, String pageStartNum, String pageListNum) {
      if(index != null) {
         this.index = Integer.parseInt(index) ;
      }
      if(pageStartNum != null) {
         this.pageStartNum = Integer.parseInt(pageStartNum);
      }
      if(pageListNum != null) {
         this.pageListNum = Integer.parseInt(pageListNum);
      }
   }
   
   //쿼리에서 만들어진 첫번째 ROWNUMBER()* index +1
   public int getStart() {
      return index * pageListNum +1;
   }
   
   //쿼리에서 만들어진 게시글의 마지막 ROWNUMBER()를 만들어 낸다.
   public int getLast() {
      return (index * pageListNum) + pageListNum;
   }
   
   public int getCount() {
      int count = 0;
      /*
       * total 게시글 전체 개수가 40개일경우 한페이지에 출력되는 게시글은 15개 = 1,2페이지 나오고 3페이지에는 10개의 게시글 출력
       * 한페이지에 출력되는 게시글 갯수 * 
       */
      int temp = total - pageListNum*(pageStartNum-1);
      int min = temp/pageListNum;
      if(temp%pageListNum != 0) {
         min++;
      }
      
      if(temp <= pageListNum) { //남아 있는 글의 갯수가 1페이지 이다
         count = pageStartNum;
      }else if(min <= pageListNum) {
         count = min + pageStartNum -1;
      }else {
         count = pageListNum +pageStartNum -1;
      }
      
      System.out.println("count index그룹의 끝번호="+count);
      
      return count;
   }
   
   public RowNumVo() {
   }

   public int getPageList() {
      return pageList;
   }

   public void setPageList(int pageList) {
      this.pageList = pageList;
   }

   public int getIndex() {
      return index;
   }

   public void setIndex(int index) {
      this.index = index;
   }

   public int getPageStartNum() {
      return pageStartNum;
   }

   public void setPageStartNum(int pageStartNum) {
      this.pageStartNum = pageStartNum;
   }

   public int getPageListNum() {
      return pageListNum;
   }

   public void setPageListNum(int pageListNum) {
      this.pageListNum = pageListNum;
   }

   public int getTotal() {
      return total;
   }

   public void setTotal(int total) {
      this.total = total;
   }

   @Override
   public String toString() {
      return "RowNumVo [pageList=" + pageList + ", index=" + index + ", pageStartNum=" + pageStartNum
            + ", pageListNum=" + pageListNum + ", total=" + total + "]";
   }

}

