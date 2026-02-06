package com.sukumar.task_reminder;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class AuthServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MockMvc mockMvc;


//	@Test
//	void login_success_returnsJwt() throws Exception {
//
//		// Register user first
//		mockMvc.perform(post("/auth/register")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content("""
//                {
//                  "email": "jwtuser22@example.com",
//                  "password": "StrongPassword123"
//                }
//            """))
//				.andExpect(status().isOk());
//
//		// Login
//		mockMvc.perform(post("/auth/login")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content("""
//                {
//                  "email": "jwtuser@example.com",
//                  "password": "StrongPassword123"
//                }
//            """))
//				.andExpect(status().isOk())
//				.andExpect(content().string(not(emptyString())));
//	}
//
//
//	@Test
//	void login_wrongPassword_fails() throws Exception {
//
//		mockMvc.perform(post("/auth/login")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content("""
//                {
//                  "email": "jwtuser@example.com",
//                  "password": "WrongPassword"
//                }
//            """))
//				.andExpect(status().isUnauthorized());
//	}
//
//
//	@Test
//	void login_userNotFound_fails() throws Exception {
//
//		mockMvc.perform(post("/auth/login")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content("""
//                {
//                  "email": "notfound@example.com",
//                  "password": "StrongPassword123"
//                }
//            """))
//				.andExpect(status().isUnauthorized());
//	}
//
//
//	@Test
//	void getUsers_withoutToken_shouldFail() throws Exception {
//
//		mockMvc.perform(get("/auth/users"))
//				.andExpect(status().isForbidden());
//	}
//
//	@Test
//	void getUsers_withInvalidToken_shouldFail() throws Exception {
//
//		mockMvc.perform(get("/auth/users")
//						.header("Authorization", "Bearer invalid.jwt.token"))
//				.andExpect(status().isForbidden());
//	}
//
//
//	@Test
//	void getUsers_withValidToken_shouldPass() throws Exception {
//
//		// Register
//		mockMvc.perform(post("/auth/register")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content("""
//                {
//                  "email": "secureuser22@example.com",
//                  "password": "StrongPassword123"
//                }
//            """))
//				.andExpect(status().isOk());
//
//		// Login and extract token
//		MvcResult loginResult = mockMvc.perform(post("/auth/login")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content("""
//                {
//                  "email": "secureuser22@example.com",
//                  "password": "StrongPassword123"
//                }
//            """))
//				.andExpect(status().isOk())
//				.andReturn();
//
//		String jwt = loginResult.getResponse().getContentAsString();
//
//		// Access protected endpoint
//		mockMvc.perform(get("/auth/users")
//						.header("Authorization", "Bearer " + jwt))
//				.andExpect(status().isOk());
//	}





//	@Test
//	void registerUser_success() throws Exception {
//		mockMvc.perform(
//						post("/auth/register")
//								.contentType(MediaType.APPLICATION_JSON)
//								.content("""
//                        {
//                          "email": "junituser@example.com",
//                          "password": "StrongPassword123"
//                        }
//                    """)
//				)
//				.andExpect(status().isOk());
//	}

//	@Test
//	void registerUser_duplicateEmail() throws Exception {
//		String body = """
//            {
//              "email": "duplicate@example.com",
//              "password": "StrongPassword123"
//            }
//        """;
//
//		// first time → OK
//		mockMvc.perform(post("/auth/register")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content(body))
//				.andExpect(status().isOk());
//
//		// second time → error
//		mockMvc.perform(post("/auth/register")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content(body))
//				.andExpect(status().isInternalServerError()); // will improve later
//	}

	// ---------- 3️⃣ INVALID EMAIL FORMAT ----------
//	@Test
//	void registerUser_invalidEmailFormat() throws Exception {
//		String body = """
//            {
//              "email": "invalid-email",
//              "password": "StrongPassword123"
//            }
//        """;
//
//		mockMvc.perform(post("/auth/register")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content(body))
//				.andExpect(status().isBadRequest());
//	}
//
//	// ---------- 4️⃣ BLANK EMAIL ----------
//	@Test
//	void registerUser_blankEmail() throws Exception {
//		String body = """
//            {
//              "email": "",
//              "password": "StrongPassword123"
//            }
//        """;
//
//		mockMvc.perform(post("/auth/register")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content(body))
//				.andExpect(status().isBadRequest());
//	}
//
//	// ---------- 5️⃣ BLANK PASSWORD ----------
//	@Test
//	void registerUser_blankPassword() throws Exception {
//		String body = """
//            {
//              "email": "blankpass@example.com",
//              "password": ""
//            }
//        """;
//
//		mockMvc.perform(post("/auth/register")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content(body))
//				.andExpect(status().isBadRequest());
//	}
//
//	// ---------- 6️⃣ MISSING EMAIL FIELD ----------
//	@Test
//	void registerUser_missingEmail() throws Exception {
//		String body = """
//            {
//              "password": "StrongPassword123"
//            }
//        """;
//
//		mockMvc.perform(post("/auth/register")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content(body))
//				.andExpect(status().isBadRequest());
//	}
//
//	// ---------- 7️⃣ MISSING PASSWORD FIELD ----------
//	@Test
//	void registerUser_missingPassword() throws Exception {
//		String body = """
//            {
//              "email": "missingpass@example.com"
//            }
//        """;
//
//		mockMvc.perform(post("/auth/register")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content(body))
//				.andExpect(status().isBadRequest());
//	}
//
//	// ---------- 8️⃣ WRONG CONTENT TYPE ----------
//	@Test
//	void registerUser_wrongContentType() throws Exception {
//		String body = """
//            {
//              "email": "wrongtype@example.com",
//              "password": "StrongPassword123"
//            }
//        """;
//
//		mockMvc.perform(post("/auth/register")
//						.contentType(MediaType.TEXT_PLAIN)
//						.content(body))
//				.andExpect(status().isUnsupportedMediaType());
//	}
//
//	// ---------- 9️⃣ INVALID JSON ----------
//	@Test
//	void registerUser_invalidJson() throws Exception {
//		String body = """
//            {
//              "email": "jsonerror@example.com",
//              "password": "StrongPassword123"
//        """;
//
//		mockMvc.perform(post("/auth/register")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content(body))
//				.andExpect(status().isBadRequest());
//	}
//
//
//	@Test
//	void getAllUsers_success() throws Exception {
//
//		// Ensure at least one user exists
//		String body = """
//        {
//          "email": "listuser@example.com",
//          "password": "StrongPassword123"
//        }
//    """;
//
//		mockMvc.perform(post("/auth/register")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content(body))
//				.andExpect(status().isOk());
//
//		// Call GET /auth/users
//		mockMvc.perform(get("/auth/users")
//						.contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$").isArray())
//				.andExpect(jsonPath("$.length()").isNotEmpty());
//	}
//
//
//	@Test
//	void getAllUsersDetails_success() throws Exception {
//
//		mockMvc.perform(get("/auth/users")
//						.contentType(MediaType.APPLICATION_JSON))
//				.andDo(print())   // 👈 THIS prints response
//				.andExpect(status().isOk());
//	}


}
