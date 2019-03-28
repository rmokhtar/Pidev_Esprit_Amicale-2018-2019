/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicesInterface;

import entitys.CommentMedia;
import java.util.ArrayList;

/**
 *
 * @author ibrah
 */
public interface ICommentMediaService {
    public ArrayList<CommentMedia> getAllCommentsByMedia(int idMedia);
    public boolean insertCommentMedia(CommentMedia comment);
    public boolean updateCommentMedia(CommentMedia comment,String newComment);
    public boolean deleteCommentMedia(CommentMedia comment);
}
