/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicesInterface;

import entitys.Media;
import java.util.ArrayList;

/**
 *
 * @author ibrah
 */
public interface IMediaService {
    public ArrayList<Media> getAllMediasByEvent(int idEvent);
     public Media findById(int id);
    public boolean insertMedia(Media media);
    public boolean deleteMedia(Media media);
}
