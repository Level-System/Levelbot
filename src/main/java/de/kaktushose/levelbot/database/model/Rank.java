package de.kaktushose.levelbot.database.model;

import javax.persistence.*;
import java.awt.*;
import java.util.List;

@Entity
@Table(name = "ranks")
public class Rank {

    @Id
    private Integer rankId;
    private long roleId;
    private int bound;
    private String color;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "rankId", referencedColumnName = "rankId")
    private List<RankReward> rankRewards;

    public Rank() {
    }

    public Rank(Integer rankId, long roleId, int bound, String color, String name) {
        this.rankId = rankId;
        this.roleId = roleId;
        this.bound = bound;
        this.color = color;
        this.name = name;
    }

    public Integer getRankId() {
        return rankId;
    }

    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public int getBound() {
        return bound;
    }

    public void setBound(int bound) {
        this.bound = bound;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RankReward> getRankRewards() {
        return rankRewards;
    }

    public void setRankRewards(List<RankReward> rankRewards) {
        this.rankRewards = rankRewards;
    }
}
