package blog.springboot.mapper;
import blog.springboot.module.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {

    User select();
}
