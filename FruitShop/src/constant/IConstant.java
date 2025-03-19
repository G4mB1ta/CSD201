package constant;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kminh
 */
public interface IConstant {

    String REGEX_YESNO = "^[YN]$"; // Chỉ chấp nhận 'Y' hoặc 'N' một lần duy nhất.
    String REGEX_NAME = "^[a-zA-Z]+$"; // Chấp nhận tên chỉ chứa chữ cái, không có ký tự đặc biệt hoặc số.
}
