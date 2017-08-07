package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pojo.User;
import com.revature.service.AppService;

@RestController
public class LoginCtrl {

	@Autowired
	AppService app;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<User> loginUser(@RequestBody User user) {
		System.out.println("updating exsisting user");
		User userReturned = app.authenticateUser(user);
		if (userReturned != null) {
			System.out.println("User's board roles: " + userReturned.getBoardRoles());
			return new ResponseEntity<User>(userReturned, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<User>(HttpStatus.NOT_ACCEPTABLE);
		}

	}

	// /*
	// * RequestMapping - for Controller classes
	// */
	//
	// @RequestMapping("/login")
	// public ModelAndView home(){
	// System.out.println("home");
	// return new ModelAndView("/static/login.html");
	// }
	//
	//
	// /*
	// * RequestMapping default to ALL Rquest Types!
	// *
	// * READ-get
	// * CREATE-post
	// * UPDATE-put
	// * DELETE-delete
	// * -trace
	// * -options
	// * -head
	// *
	// */
	// @RequestMapping(value= "/login", method=RequestMethod.POST)
	// public @ResponseBody String login(User user, HttpServletRequest req){
	// System.out.println("LoginCtrl");
	// System.out.println("User Entered" + user);
	// System.out.println("Requested user" + req.getParameter("username"));
	// return "Home Page message, a Json Object";
	// }
	//

	// @RequestMapping(value= "/login", method=RequestMethod.GET)
	// public ModelAndView home(){
	// System.out.println("home");
	// return new ModelAndView("/static/index.html");
	// }

	/*
	 * RequestMapping default to ALL Rquest Types!
	 * 
	 * READ-get CREATE-post UPDATE-put DELETE-delete -traceS -options -head
	 * 
	 */

	// @RequestMapping(value= "/login", method=RequestMethod.POST, consumes =
	// MediaType.APPLICATION_JSON_VALUE,
	// headers={"content-type=application/json,application/xml"})
	// public @ResponseBody String login( @RequestBody String s ){
	//
	//// System.out.println("Respose= " + req);
	//// System.out.println("username= "+ u.getUsername());
	//// System.out.println("String value"+ u);
	//// if(resp.getParameter("username")== "jay" ){
	////
	// User user =null;
	// String json = null;
	// if(s == null){
	//
	// System.out.println("String is null");
	// }
	// else{
	// System.out.println("String is not null");
	// System.out.println(s);
	//// Gson gson = new
	// GsonBuilder().setDateFormat("yyyy-MM-dd'T'HHmm:ssZ").create();
	//// WorkDto dto = gson.fromJson(wo, WorkDto.class);
	//// Work workDao = WorkTransformator.transform(dto);
	//// workDao.persist();
	//// return Response.ok().build();
	//
	// ObjectMapper objectMapper = new ObjectMapper();
	// try {
	// user= objectMapper.readValue(s, User.class);
	//
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	//
	//// return "You logged in successfully";
	// ObjectMapper mapper = new ObjectMapper();
	// try {
	// if(!user.getUsername().equals("jay")&& !
	// user.getPassword().equals("123")){
	// System.out.println("In the if loop");
	// user.setUsername(null);
	// user.setPassword(null);
	// }
	// System.out.println("Username->"+ user.getUsername());
	// System.out.println("Password->"+ user.getPassword());
	// json = mapper.writer().writeValueAsString(user);
	// System.out.println("json is = "+ json);
	// } catch (JsonProcessingException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return json;
	//// }
	//// System.out.println("LoginCtrl");
	//// System.out.println("Requested user: " + req.getParameter("username"));
	//// return "You failed logging in";
	// }

}
