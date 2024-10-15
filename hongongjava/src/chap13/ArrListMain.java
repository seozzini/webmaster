package chap13;

import java.util.ArrayList;
import java.util.List;

public class ArrListMain {

	public static void main(String[] args) {
		// List 컬렉션
		// ArrayList
		List<String> list = new ArrayList<String>();

		// 객체 추가
		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "Database");
		list.add("iBATIS");

		// List 크기
		int size = list.size();
		System.out.println("총 객체 수: " + size);
		System.out.println();

		// 리스트 객체 가져오기
		String skill = list.get(2);
		System.out.println("2: " + skill);
		System.out.println();

		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ": " + str);
		}
		System.out.println();

		// 삭제하기
		list.remove(2);
		list.remove(2);
		list.remove("iBATIS");

		// 전체 출력-for문
//		for(int i=0;i<list.size();i++) {
//			String str = list.get(i);
//			System.out.println(i+": "+str);
//		}

		// 전체 출력-향상된 for 문
		for (String obj : list) {
			System.out.println(obj);
		}

	}

}
