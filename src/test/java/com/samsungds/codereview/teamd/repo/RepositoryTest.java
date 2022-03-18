package com.samsungds.codereview.teamd.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.samsungds.codereview.teamd.vo.Employee;

@ExtendWith(MockitoExtension.class)
class RepositoryTest {

	@Mock
	IRepository repo;

	@Test
	void testAdd() {
		Employee emp = new Employee("00123456", "�浿 ȫ", "CL3", "010-001-0001", "20000101", "PRO");
		
		when(repo.add(emp)).thenReturn(Integer.valueOf("20"+emp.getEmployeeNum()));
		
		assertEquals(Integer.valueOf("20"+emp.getEmployeeNum()), repo.add(emp));
	}

	@Test
	void testDelete() {
		Map<Integer, Employee> map = new HashMap<>();

		when(repo.delete(anyString(), anyString())).thenReturn(map);

		assertEquals(map, repo.delete("name", "test"));
	}

	@Test
	void testModify() {
		Map<Integer, Employee> map = new HashMap<>();

		when(repo.modify(anyString(), anyString())).thenReturn(map);

		assertEquals(map, repo.modify("name", "test"));
	}

	@Test
	void testSearch() {
		Map<Integer, Employee> map = new HashMap<>();

		when(repo.search(anyString(), anyString())).thenReturn(map);

		assertEquals(map, repo.search("name", "test"));
	}

}
