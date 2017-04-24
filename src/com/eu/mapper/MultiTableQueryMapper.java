package com.eu.mapper;

import com.eu.pojo.CommunityContacts;

import java.util.List;

/**
 * Created by lip on 17/4/19.
 */
public interface MultiTableQueryMapper {

    List<CommunityContacts> selectContactsByCmid(Integer cmid);

    Integer searchActivityCountByKeyword(String keyword);

    Integer searchCommunityCountByKeyword(String keyword);

    Integer searchUserCountByKeyword(String keyword);
}
