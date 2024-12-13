package com.expample.clush_backend.service;

import com.expample.clush_backend.repository.GroupRepository;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    private GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

}
