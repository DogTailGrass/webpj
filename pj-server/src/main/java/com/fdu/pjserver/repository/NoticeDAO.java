package com.fdu.pjserver.repository;

import com.fdu.pjserver.dao.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NoticeDAO extends JpaRepository<Notice, Integer>, JpaSpecificationExecutor<Notice> {
}
