package cn.team.utils;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {

	private int startIndex;//起始查询的索引位置   计算     (pageNum-1)*size
	private int size;//每页显示多少条数据		       已知
	
	private List<T> list = new ArrayList<T>();//存放分页查询出来的对象的集合
	//  1 2  3  4   5
	// 10
	// 6 7 8 9 10
	private int start;//开始的页数			计算      pageNum-2>0 &&  start>0?  pageNum-2:1
	private int end;//结束页数			          计算	  pageNum+2<=totalPage && end<=totalPage ?  pageNum+2:totalPage
	
	private int totalPage;//总页数		 计算     total/size==0?total/size:total/size+1 
	private int pageNum;//当前页数			   已知
	private int total;//总记录数			 已知  查询数据库
	
	/**
	 * 通过已知的条件，计算出其他的属性值，并且赋值
	 * @param size
	 * @param pageNum
	 * @param total
	 */
	public PageBean(int size, int pageNum, int total) {
		super();
		this.size = size;
		this.pageNum = pageNum;
		this.total = total;
		
		startIndex =  (pageNum-1)*size;
		totalPage = total%size==0?total/size:total/size+1;
		
		//初始值
		start = 1;
		end = 5;
		
		//1. 总页数小于5
		if(totalPage<5){
			start = 1;
			end = totalPage;
		}else{//2.总页数大于5    start = pageNum-2    end = pageNum+2
			start = pageNum -2;
			end = pageNum +2;
			//  start  小于1
			if(start<1){
				start = 1;
				end = 5;
			}
			
			if(end>totalPage){//如果结束页数大于总页数        
				end = totalPage;//结束页就是总页数
				start = end-4;//开始页就是 结束页-4    start与end相差4            
			}
			
		}
	}
	
	
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return "PageBean [startIndex=" + startIndex + ", size=" + size + ", list=" + list + ", start=" + start
				+ ", end=" + end + ", totalPage=" + totalPage + ", pageNum=" + pageNum + ", total=" + total + "]";
	}
	
	
	
	
}
