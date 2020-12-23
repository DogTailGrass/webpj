package com.fdu.pjserver.service.impl;

import com.fdu.pjserver.dao.Notice;
import com.fdu.pjserver.repository.NoticeDAO;
import com.fdu.pjserver.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDAO noticeDAO;

    public Notice add(Notice notice) {
        return noticeDAO.save(notice);
    }

    public void delete(Integer id) {

    }

    public Notice update(Notice notice) {
        return noticeDAO.saveAndFlush(notice);
    }

    public Optional<Notice> retrieve(Integer id) {
        return noticeDAO.findById(id);
    }

    public List<Notice> retrieveAll() {
        return noticeDAO.findAll();
    }
}
