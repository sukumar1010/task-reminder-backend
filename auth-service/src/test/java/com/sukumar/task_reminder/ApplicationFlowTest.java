package com.sukumar.task_reminder;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ApplicationFlowTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

//    @Autowired
//    EmailService emailService;
//
//    private String obtainJwt() throws Exception {
//
//
//
//        MvcResult result = mockMvc.perform(post("/auth/login")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("""
//                {
//                  "email": "jwtuser22@example.com",
//                  "password": "StrongPassword123"
//                }
//            """))
//                .andReturn();
//
//        return result.getResponse().getContentAsString();
//    }
//
//    @Test
//    void createTask_success() throws Exception {
//
//        String jwt = obtainJwt();
//
//        mockMvc.perform(post("/tasks")
//                        .header("Authorization", "Bearer " + jwt)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("""
//                {
//                  "title": "Finish Spring Boot Project",
//                  "reminderDate": "2026-01-20",
//                  "dueDate": "2026-01-25"
//                }
//            """))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void createTask_invalidDates_shouldFail() throws Exception {
//
//        String jwt = obtainJwt();
//
//        mockMvc.perform(post("/tasks")
//                        .header("Authorization", "Bearer " + jwt)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("""
//                {
//                  "title": "Invalid Task",
//                  "reminderDate": "2026-01-30",
//                  "dueDate": "2026-01-20"
//                }
//            """))
//                .andExpect(status().isBadRequest());
//    }
//
//
//    @Test
//    void getAllTasks_success() throws Exception {
//
//        String jwt = obtainJwt();
//
//        mockMvc.perform(get("/tasks")
//                        .header("Authorization", "Bearer " + jwt))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void markTaskCompleted_success() throws Exception {
//
//        String jwt = obtainJwt();
//
//        MvcResult createResult = mockMvc.perform(post("/tasks")
//                        .header("Authorization", "Bearer " + jwt)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("""
//                {
//                  "title": "Complete Me",
//                  "reminderDate": "2026-01-20",
//                  "dueDate": "2026-01-25"
//                }
//            """))
//                .andReturn();
//
//        Integer taskId = JsonPath.read(
//                createResult.getResponse().getContentAsString(),
//                "$.id"
//        );
//        Long taskId2 = taskId.longValue();
//
//        mockMvc.perform(put("/tasks/" + taskId2 + "/complete")
//                        .header("Authorization", "Bearer " + jwt))
//                .andExpect(status().isOk());
//    }
//
//
//    @Test
//    void markTaskAlreadyCompleted_shouldFail() throws Exception {
//
//        String jwt = obtainJwt();
//
//        MvcResult result = mockMvc.perform(post("/tasks")
//                        .header("Authorization", "Bearer " + jwt)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("""
//                {
//                  "title": "Already Done",
//                  "reminderDate": "2026-01-20",
//                  "dueDate": "2026-01-25"
//                }
//            """))
//                .andReturn();
//
//        Integer taskId = JsonPath.read(result.getResponse().getContentAsString(), "$.id");
//        Long taskId2 = taskId.longValue();
//        mockMvc.perform(put("/tasks/" + taskId2 + "/complete")
//                .header("Authorization", "Bearer " + jwt));
//
//        mockMvc.perform(put("/tasks/" + taskId + "/complete")
//                        .header("Authorization", "Bearer " + jwt))
//                .andExpect(status().isBadRequest());
//    }
//
//



}

