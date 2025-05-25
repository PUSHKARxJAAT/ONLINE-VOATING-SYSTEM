package dao;

import model.Vote;
import java.sql.*;

public class VoteDAO {

    public static boolean insertVote(Vote vote) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO votes (voter_id, candidate) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, vote.getVoterId());
            ps.setString(2, vote.getCandidate());
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int countVotes(String candidateName) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT COUNT(*) FROM votes WHERE candidate = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, candidateName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
