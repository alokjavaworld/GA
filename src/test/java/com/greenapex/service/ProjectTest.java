package com.greenapex.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.greenapex.exception.ProjectAlreadyExist;
import com.greenapex.exception.ProjectNotFoundException;
import com.greenapex.model.Project;
import com.greenapex.repository.IProjectRepo;
import com.greenapex.service.impl.ProjectServiceImpl;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ProjectTest {

	@Mock
	IProjectRepo repo;

	@InjectMocks
	ProjectServiceImpl service;

	// setup
	@BeforeEach
	public void setUp() {
		when(repo.save(Mockito.any())).thenReturn(createDummyProject());
		when(repo.findById(Mockito.any())).thenReturn(Optional.of(createDummyProject()));
		when(repo.findAll()).thenReturn(List.of(createDummyProject()));
	}

	@DisplayName("Add Project test")
	@Test
	public void addProject() throws ProjectAlreadyExist {
		Project proj = service.save(createDummyProject());
		assertEquals(101, proj.getPid());
		assertEquals("jk", proj.getClientName());
		assertEquals("App", proj.getPname());
	}

	@DisplayName("Get ProjectById Test")
	@Test
	public void getProjByIdTest() throws ProjectNotFoundException {
		Project proj = service.findByid(101);
		assertEquals(101, proj.getPid());
	}

	@DisplayName("Get All Project Test")
	//@Test
	public void getAllProjTest() throws ProjectNotFoundException {
		List<Project> listProj = service.getAllPoj();
		System.out.println(listProj.size());
		assertEquals(true, listProj.size()>0);

	}
	
//	public static List<Project> lsitOfProjects(){
//		List<Project> proj= new ArrayList<Project>();
//		for(int i=0;i<10;i++) {
//			Project p= new Project();
//			p.setClientName("jk");
//			p.setPid(101);
//			p.setPname("sk");
//			proj.add(p);
//		}
//		return proj;
//	}

	public static Project createDummyProject() {
		Project proj = new Project();
		proj.setPid(101);
		proj.setClientName("jk");
		proj.setPname("App");
		return proj;
	}
}
