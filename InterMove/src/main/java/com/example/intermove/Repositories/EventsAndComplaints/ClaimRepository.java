package com.example.intermove.Repositories.EventsAndComplaints;

import com.example.intermove.Entities.EventsAndComplaints.Claim;
import com.example.intermove.Entities.EventsAndComplaints.Events;
import com.example.intermove.Services.EventsAndComplaints.DuplicateComplainers;
import com.example.intermove.Services.EventsAndComplaints.MostComplainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClaimRepository extends JpaRepository<Claim,Integer> {
    List<Claim> findByStatus(boolean status);
    @Query(value="select users.nom ,count(claim.user_id) occ from claim claim"
            + " left join user users on claim.user_id =users.id"
            + " group by claim.user_id"
            + " Order by occ"
            + " DESC ",nativeQuery=true)

    public List<MostComplainer> mostComplainer();
    @Query(value="select distinct users.mail , count(cmp.id) as doublon from user users left join claim cmp on users.id=cmp.user_id group by (cmp.id) ",nativeQuery=true)
    public List<DuplicateComplainers> getDuplicateComplainers();
}
