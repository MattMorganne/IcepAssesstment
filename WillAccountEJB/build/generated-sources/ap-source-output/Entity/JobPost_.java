package Entity;

import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-07-12T20:18:30")
@StaticMetamodel(JobPost.class)
public class JobPost_ { 

    public static volatile SingularAttribute<JobPost, List> studentId;
    public static volatile SingularAttribute<JobPost, String> description;
    public static volatile SingularAttribute<JobPost, String> course;
    public static volatile SingularAttribute<JobPost, Long> id;
    public static volatile SingularAttribute<JobPost, String> title;
    public static volatile SingularAttribute<JobPost, Date> expDate;
    public static volatile SingularAttribute<JobPost, String> CompanyCode;

}