package com.expample.clush_backend.controller;

import com.expample.clush_backend.dto.ClushResponse;
import com.expample.clush_backend.model.Group;
import com.expample.clush_backend.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GroupController {

    private GroupService groupService;

    public GroupController(GroupService groupService){
        this.groupService = groupService;
    }

    @GetMapping("/group/search/{groupName}")
    public ResponseEntity<?> searchGroup(@PathVariable String groupName) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ClushResponse(200, groupName,"searchGroup"));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ClushResponse(500, groupName, e.getMessage()));
        }
    }

    @PostMapping("/group/create")
    public ResponseEntity<?> createGroup(@RequestBody Group group) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ClushResponse(200, group,"createGroup"));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ClushResponse(500, group, e.getMessage()));
        }
    }

    @PostMapping("/group/apply/{groupName}")
    public ResponseEntity<?> applyGroup(@PathVariable String groupName) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ClushResponse(200, groupName, "applyGroup"));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ClushResponse(500, groupName, e.getMessage()));
        }
    }

    @DeleteMapping("/group/delete/{groupId}/{userId}")
    public ResponseEntity<?> deleteGroup(@PathVariable String groupId, @PathVariable String userId) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ClushResponse(200, groupId,"deleteGroup"));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ClushResponse(500, groupId, e.getMessage()));
        }
    }

    @PostMapping("/group/delegate")
    public ResponseEntity<?> delegateMaster(@RequestBody Group group) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ClushResponse(200, group,"delegateMaster"));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ClushResponse(500, group,e.getMessage()));
        }
    }





}
