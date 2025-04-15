"use client"
import { useEffect, useState } from "react";
import axios from "axios";
import process from "next/dist/build/webpack/loaders/resolve-url-loader/lib/postcss";
import CustomNavbar from "@/components/Navbar";

export default function Home(params) {
  const [books, setBooks] = useState([]);
  const [loading, setLoading] =useState([]);

  useEffect(()=>{
    axios.get(' http://localhost:3000')
        .then(response =>{
          setBooks(response.data)
          setLoading(false);
        })
        .catch(error => {
          console.log("API Error",error);
          setLoading(false);
        });
  },[])

  return (
     <CustomNavbar></CustomNavbar>
  );
}