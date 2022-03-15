package org.test.mapper;

import org.test.entity.Blog;

public interface BlogMapper {

  Blog selectByBlogId (Integer blogId);
}
