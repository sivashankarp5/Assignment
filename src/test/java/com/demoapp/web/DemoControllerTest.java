package com.demoapp.web;

import com.demoapp.service.ApplicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ApplicationService applicationService;

    @Test
    public void getAllFiles() throws Exception {

        //Create a post request with an accept header for application\json
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/demo/files/")
                .contentType(MediaType.APPLICATION_JSON)
                .param("directory","C:\\Temp");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        //Assert that the return status is OK
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void getFileDetails() throws Exception {

        //Create a post request with an accept header for application\json
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/demo/file/")
                .contentType(MediaType.APPLICATION_JSON)
                .param("filePath","C:\\Temp\\ex1.txt");


        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        //Assert that the return status is OK
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}
