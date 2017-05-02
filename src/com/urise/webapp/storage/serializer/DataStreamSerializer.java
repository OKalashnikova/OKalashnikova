package com.urise.webapp.storage.serializer;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.ContactType;
import com.urise.webapp.model.Resume;

import java.io.*;
import java.util.Map;

/**
 * Created by OK on 26.03.2017.
 */
public class DataStreamSerializer implements StreamSerializer{

    @Override
    public void doWrite(Resume r, OutputStream os) throws IOException {
        try(DataOutputStream dos = new DataOutputStream(os)){
            dos.writeUTF(r.getUuid());
            dos.writeUTF(r.getFullName());

            Map<ContactType, String> contacts = r.getContacts();
            dos.writeInt(contacts.size());
            for(Map.Entry<ContactType, String> entery: contacts.entrySet()){
                dos.writeUTF(entery.getKey().name());
                dos.writeUTF(entery.getValue());
            }
            //TODO IMPLEMENTS SECTIONS
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
       try(DataInputStream dis = new DataInputStream(is)){
           String uuid = dis.readUTF();
           String fullNamme = dis.readUTF();
           Resume resume = new Resume(uuid, fullNamme);
           int size = dis.readInt();
           for (int i = 0; i < size; i++){
               resume.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF());
           }

//           for (int i = 0; i < size; i++){
//               ContactType contactType = ContactType.valueOf(dis.readUTF());
//               String value = dis.readUTF();
//               resume.addContact(contactType, value);
//           }
           // Pri pomoschi Cntrl+Alt+N zarefaktily tak, kak napisan cikl vishe
           //TODO IMPLEMENTS SECTIONS
       return resume;
       }
    }
}
