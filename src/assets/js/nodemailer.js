const nodemailer=require('nodemailer');
const transporter=nodemailer.createTransport({
  service:"gmail",
  auth:{
    user:"naoures.hajri1@esprit.tn",
    pass:"Naoures@hajri91"
  },
  tls: {
    rejectUnauthorized:false,
  },
});

const options={
  from:"naoures.hajri1@esprit.tn",
  to:"naoures.hajri91@gmail.com",
  subject:"Promotions",
  text:"Hi!!!! You can take advantage of our promotions ranging from 30% to 70% in our different products."
};

transporter.sendMail(options,function (err, info){
  if(err){
    console.log(err);
    return;
  }
    console.log("Sent: "+ info.response);
})


