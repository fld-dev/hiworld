package com.shiro.testshiro.pojo.database2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@Builder
@Table(name = "gw_game_ppc_user_info")
public class PPCUserInfo {
    @Id
    @Column(name = "account")
    public String account;

    @Column(name = "ppc_profit")
    public BigDecimal ppcProfit;

    @Column(name = "ppc_frozen")
    public Long ppcFrozen;

    @Column(name = "ppc_flow")
    public Long ppcFlow;

    @Column(name = "ppc_score")
    public BigDecimal ppcScore;

    @Column(name = "create_date")
    public Timestamp createDate;
}
