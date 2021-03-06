package com.board.sy.dao;

import com.board.sy.domain.BoardDto;
import com.board.sy.domain.PostDto;
import com.board.sy.domain.SearchCondition;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDaoImpl implements PostDao{
    @Autowired
    SqlSession session;
    private static String namespace = "com.board.sy.dao.PostMapper.";

    @Override
    public PostDto getPost(String pno) throws Exception{
        return session.selectOne(namespace+"select",pno);
    }
    @Override
    public BoardDto getBoard(String pno) throws Exception{
        return session.selectOne(namespace+"selectBoard",pno);
    }

    @Override
    public int writePost(PostDto dto) throws Exception{
        return session.insert(namespace + "insertPost", dto);
    }
    @Override
    public String makePno() throws Exception{
        return session.selectOne(namespace+"createPno");
    }

    @Override
    public int modifyPost(PostDto dto) throws Exception{
        return session.update(namespace + "updatePost",dto);
    }

    @Override
    public int deletePost(String pno) throws Exception{
        return session.delete(namespace+"deletePost", pno);
    }

    @Override
    public int increaseViewCnt(String pno)throws Exception{
        return session.update(namespace+"increaseViewCnt", pno);
    }

    @Override
    public int deleteAll() throws Exception{
        return session.delete(namespace+"deleteAll");
    }

    @Override
    public int count() throws Exception{
        return session.selectOne(namespace+"count");
    }
}
