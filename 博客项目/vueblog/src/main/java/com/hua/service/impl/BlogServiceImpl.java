package com.hua.service.impl;

import com.hua.entity.Blog;
import com.hua.mapper.BlogMapper;
import com.hua.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hua
 * @since 2021-08-12
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
