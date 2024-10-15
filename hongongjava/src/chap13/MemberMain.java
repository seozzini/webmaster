package chap13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MemberMain {

	public static void main(String[] args) {
		Set<Member> set = new HashSet<Member>();
		
		set.add(new Member("홍길동",30));
		set.add(new Member("홍길동",30));
		set.add(new Member("최길동",25));
		set.add(new Member("최길동",30));
		
		System.out.println("총 객체 수: "+set.size());
		
		//set 전체 출력 (2가지 방법)
		//1. iterator
		Iterator<Member> ir = set.iterator();
		while(ir.hasNext()) {
			Member m = ir.next();
			System.out.println(m.name+" : "+m.age);
		}
		//2. 향상된 for 문
		for(Member m:set) {
			System.out.println(m.name+" : "+m.age);
		}

	}

}
