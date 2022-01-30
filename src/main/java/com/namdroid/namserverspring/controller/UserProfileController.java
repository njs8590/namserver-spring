package com.namdroid.namserverspring.controller;

import com.namdroid.namserverspring.mapper.IUserProfileMapper;
import com.namdroid.namserverspring.model.UserProfile;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController //Spring 프레임워크는 어노테이션 기반이라서 하위 클래스를 컨트롤러로 인식하고 인스턴스를 생성하게됨.
public class UserProfileController {

    private IUserProfileMapper mapper;

    private Map<String, UserProfile> userProfileMap;

    public UserProfileController(IUserProfileMapper mapper){
        this.mapper = mapper;
    }

    @PostConstruct
    public void init(){
        userProfileMap = new HashMap<>();

        // Test
        userProfileMap.put("1", new UserProfile("1", "홍길동", "123-1234", "한국", "10"));
        userProfileMap.put("2", new UserProfile("2", "제니퍼", "234-2345", "영국", "10"));

    }

    /*
    GET: 데이터 조회
    POST: 생성
    PUT: 수정
    DELETE: 삭제
     */
    // Userprofile 을 json 형태로 반환해주는 함수
    @GetMapping("/user/{id}")
    public UserProfile getUserProfileById(@PathVariable("id") String id){ // PathVariable 써주면 파라미터를 path에 있는 {id} 로 전달하게됨.
        // return userProfileMap.get(id);
        return mapper.getUserProfileById(id);
    }


//    @GetMapping("/user/all")
//    public List<UserProfile> getUserProfileList(){
//
//        return new ArrayList<UserProfile>(userProfileMap.values());
//    }

    //Userprofile 생성 api
    @PostMapping("/user/{id}")
    public void postUserProfile(@RequestParam("id") String id,@RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address){
//        UserProfile userProfile= new UserProfile(id, name, phone, address, "10");
//        userProfileMap.put(id, userProfile);
        mapper.insertUserProfile(id, name, phone, address, "10");
    }

    //Userprofile 수정 api
    @PutMapping("/user/{id}")
    public void putUserProfile(@RequestParam("id") String id,@RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address){
//        UserProfile userProfile = userProfileMap.get(id);
//        userProfile.setName(name);
//        userProfile.setPhone(phone);
//        userProfile.setAddress(address);

        mapper.updateUserProfile(id, name, phone, address);
    }

    @DeleteMapping("/user/{id}")
    public void deleteuserProfile(@RequestParam("id") String id){
//        userProfileMap.remove(id);

        mapper.updateUserProfileValid(id, "90");
    }


}
