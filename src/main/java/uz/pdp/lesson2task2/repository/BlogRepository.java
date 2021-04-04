package uz.pdp.lesson2task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.lesson2task2.entity.Blog;
import uz.pdp.lesson2task2.projection.CustomBlog;

@RepositoryRestResource(path = "blog", excerptProjection = CustomBlog.class)
public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
