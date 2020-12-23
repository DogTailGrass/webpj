package com.fdu.pjserver.service;

import com.fdu.pjserver.dao.Notice;

import java.util.List;
import java.util.Optional;

public interface NoticeService {
    Notice add(Notice notice);

    void delete(Integer id);

    Notice update(Notice notice);

    Optional<Notice> retrieve(Integer id);

    List<Notice> retrieveAll();
}
