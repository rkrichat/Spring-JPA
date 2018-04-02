package com.spring.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JpaApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void searchUser_byId_exist_mustFound() throws Exception{
		mockMvc.perform(get("/user/Kritchat"))
				.andExpect(jsonPath("id").value("rkritchat"));
	}

	@Test
	public void searchUser_byId_noExist_mustNotFound() throws Exception{
		MvcResult result = mockMvc.perform(get("/user/noExist"))
				.andReturn();

		assertEquals(result.getResponse().getContentAsString(),"");
	}

	@Test
    public void searchUser_byEmail_exist_mustFound() throws Exception{
	    mockMvc.perform(get("/user?email=kritchat@gmail.com"))
                .andExpect(jsonPath("name").value("kr"));
	                                    
    }

}
